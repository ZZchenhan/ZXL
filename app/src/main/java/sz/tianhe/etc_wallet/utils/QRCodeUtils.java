package sz.tianhe.etc_wallet.utils;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.EnumMap;
import java.util.Map;

/**
 * 项目名称:tokenChat
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/2 14:27
 * 二维码工具类
 */
public class QRCodeUtils {
    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;

    /**
     * 生成二维码
     *
     * @return
     * @throws WriterException
     */
    public static Bitmap encodeAsBitmap(String contents, int widthDei, int heightDei) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);
        if (encoding != null) {
            hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.MARGIN, 0);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }

        BitMatrix result;
        try {
            //生成二维码格式
            result = new QRCodeWriter().encode(contentsToEncode, BarcodeFormat.QR_CODE, widthDei, heightDei, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        result = updateBit(result,8);
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];//像素点
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {//如果>255 因为像素点为0-255之间
                return "UTF-8";
            }
        }
        return null;
    }

    /**
     * 清除二维码白边
     * @param matrix
     * @param margin
     * @return
     */
    private static BitMatrix updateBit(BitMatrix matrix, int margin) {
        int tempM = margin * 2;
        int[] rec = matrix.getEnclosingRectangle();
        // 获取二维码图案的属性
        int resWidth = rec[2] + tempM;
        int resHeight = rec[3] + tempM;
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        // 按照自定义边框生成新的
        resMatrix.clear();
        for (int i = margin; i < resWidth - margin; i++) {
            // 循环,将二维码图案绘制到新的bitMatrix中
            for (int j = margin; j < resHeight - margin; j++) {
                if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }
}
