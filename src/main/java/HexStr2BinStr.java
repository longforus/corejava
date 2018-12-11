/**
 * This program displays a greeting for the reader.
 * @version 1.30 2014-02-27
 * @author Cay Horstmann
 */
public class HexStr2BinStr
{
   private static String hexStr =  "0123456789ABCDEF";
   private static String[] binaryArray =
       {"0000","0001","0010","0011",
           "0100","0101","0110","0111",
           "1000","1001","1010","1011",
           "1100","1101","1110","1111"};
   public static void main(String[] args)
   {
      String greeting = "DA2D7E7218B8F5ED7B491102910C4A960C0718C7";
      System.out.println(greeting);
      byte[] bytes = HexStringToBinary(greeting);
      for (int b = 0; b < bytes.length; b++) {
         System.out.println(byteToBit(bytes[b]));
      }
      for (int i = 0; i < greeting.length(); i++)
         System.out.print("=");
      System.out.println();

   }


   /**
    * 把byte转为字符串的bit
    */
   public static String byteToBit(byte b) {
      return ""
          + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
          + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
          + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
          + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
   }

   /**
    *
    * @param hexString
    * @return 将十六进制转换为字节数组
    */
   public static byte[] HexStringToBinary(String hexString){
      //hexString的长度对2取整，作为bytes的长度
      int len = hexString.length()/2;
      byte[] bytes = new byte[len];
      byte high = 0;//字节高四位
      byte low = 0;//字节低四位

      for(int i=0;i<len;i++){
         //右移四位得到高位
         high = (byte)((hexStr.indexOf(hexString.charAt(2*i)))<<4);
         low = (byte)hexStr.indexOf(hexString.charAt(2*i+1));
         bytes[i] = (byte) (high|low);//高地位做或运算
      }
      return bytes;
   }
}
