import cn.itcast.stream.producer.messageSender;
import cn.itcast.stream.streamProducerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = streamProducerApplication.class)
public class producerTest {
    @Autowired
    private messageSender messageSender;
    @Test
    public void senderTest(){
        for (int i=0;i<5;i++)
        messageSender.sender("8");
    }
}
