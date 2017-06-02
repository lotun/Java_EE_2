package ro.mti.Java_EE_2;
    import java.io.UnsupportedEncodingException;
    import java.math.BigInteger;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;
     
    public class MD5Hash {
    	public static String getHash(String str) throws NoSuchAlgorithmException,
    													UnsupportedEncodingException{
    	    //String s="f78spx";
    	    MessageDigest m=MessageDigest.getInstance("MD5");
    	    m.reset();
    	    //�������� � MessageDigest ����� ������. ������� ������� �����������.
    	    m.update(str.getBytes("utf-8"));
    	    //�������� MD5-��� ������ ��� ���������� �����
    	    String s2 = new BigInteger(1,m.digest()).toString(16);
    	    //��������� ������ �� 32 ��������, � ������ �������������
    	    while(s2.length() < 32 ){
    	    	s2 = "0"+s2;
    	    }
    	    //���������� MD5-���
    	    return s2;
    	}
    }