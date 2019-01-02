import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroSaltTest {
    public static void main(String[] args) {
        //密码
        String password ="1234";
        //盐值
        String salt = "abc";
        //加密次数
        int hashIterations = 1;
        //调用 org.apache.shiro.crypto.hash.Md5Hash.Md5Hash(Object source, Object salt, int hashIterations)构造方法实现MD5盐值加密
        Md5Hash mh = new Md5Hash(password, salt, hashIterations);
        //打印最终结果
        System.out.println(mh.toString());

         /*调用org.apache.shiro.crypto.hash.SimpleHash.SimpleHash(String algorithmName, Object source, Object salt, int hashIterations)
         * 构造方法实现盐值加密  String algorithmName 为加密算法 支持md5 base64 等*/
        SimpleHash sh = new SimpleHash("md5", password, salt, hashIterations);
        //打印最终结果
        System.out.println(sh.toString());

    }
}
