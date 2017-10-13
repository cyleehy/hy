package com.hy.common.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李春雷
 * @version V1.0
 * @description [
 *      图片工具类
 *          v1.0    根据图片url获取图片宽和高  getWidthAndHeightByUrl
 *                  根据图片url获取图片对象    getImageByUrl
 * ]
 * @created 2017-10-13 下午5:18
 */
public class ImageUtil {

    /**
     * @description [ 通过URL获取图片的宽高map ]
     * @method
     * @param
     * @return
     * @date: 2017/10/13 下午5:54
     * @author: 李春雷
    */
    public static Map<String,Integer> getWidthAndHeightByUrl (String ImageUrl)  throws Exception {
        BufferedImage image = getImageByUrl(ImageUrl);
        return new HashMap<String,Integer>(){{
            put("width",image.getWidth());
            put("height",image.getHeight());
        }};
    }

    /**
     * @description [ 通过URL获取图片对象 ]
     * @method
     * @param
     * @return
     * @date: 2017/10/13 下午6:00
     * @author: 李春雷
    */
    public static BufferedImage getImageByUrl (String ImageUrl) throws Exception {
        try {
            URL url = new URL(ImageUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            BufferedImage image = ImageIO.read(urlConnection.getInputStream());
            return image;
        } catch (Exception e) {
            throw e;
        }
    }

}
