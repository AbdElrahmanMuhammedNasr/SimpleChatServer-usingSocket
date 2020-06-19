package com.example.sockert.Repo;

import com.example.sockert.Model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo  extends JpaRepository<ChatMessage, Long> {
}
