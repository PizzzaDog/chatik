package by.overone;

import by.overone.entity.Message;
import by.overone.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public boolean addMessage(String username, String text) {
        if (text == null || text.isEmpty()) return false;
        Message message = new Message();
        message.setSender(username);
        message.setText(text);
        String time = LocalDateTime.now().toString();
        message.setTime(time.substring(11, 19));
        messageRepository.save(message);
        return true;
    }
}
