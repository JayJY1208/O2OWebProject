package com.itwillbs.chat.model.service;


import com.itwillbs.chat.model.domain.ChatMessageDTO;
import com.itwillbs.chat.model.domain.ChatRoomDTO;
import com.itwillbs.chat.model.domain.ChatRoomEnterDTO;
import com.itwillbs.chat.repository.ChatRepository;
import com.itwillbs.chat.repository.ChatRoomEnterRepository;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.inject.Inject;
import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatRoomEnterRepository chatRoomEnterRepository;
    private final Map<String,ChatRoomDTO> chatRooms =new HashMap<String,ChatRoomDTO>();

    private ChatRoomDTO chatRoomDTO;

    @Override
    public void save(ChatMessageDTO message) {
        chatRepository.saveChat(message);
    }

    @Override
    public Optional<ChatRoomEnterDTO> findById(String session_name) {

        return chatRoomEnterRepository.findById(session_name);
    }

    @Override
    public List<ChatRoomEnterDTO> findByUser(MemberDTO user) {
        return chatRoomEnterRepository.findByUser(user);
    }

    @Override
    public List<ChatRoomEnterDTO> findByPro(ProDTO pro) {
        return chatRoomEnterRepository.findByPro(pro);
    }

    @Override
    public List<ChatRoomEnterDTO> findByChatRoom(String roomId) {
        return chatRoomEnterRepository.findByChatRoom(roomId);
    }

    @Override
    public List<ChatMessageDTO> getChatMessage(String session_name) {
        return chatRepository.getChatMessage(session_name);
    }
}
