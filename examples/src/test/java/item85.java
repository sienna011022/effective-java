import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static jdk.nashorn.internal.runtime.AstDeserializer.deserialize;
import static jdk.nashorn.internal.runtime.AstSerializer.serialize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class item85 {

    @Test
    void socket() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 8080));

        byte[] bytes;
        String message;

        OutputStream os = socket.getOutputStream(); // 출력 스트림
        message = "적재적소 스터디원들 파이팅~";
        bytes = message.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes);// 문자열 -> 바이트
        os.write(bytes); // 출력 스트림에 바이트를 쓰고
        os.flush(); // flush를 날리면 그 소켓으로 출력이 된다

        String str = new String(bytes);
        System.out.println(str);
    }



}
