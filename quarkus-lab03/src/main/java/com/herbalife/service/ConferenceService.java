package com.herbalife.service;

import com.herbalife.dto.TopicOutputDto;
import com.herbalife.entity.Topic;
import com.herbalife.exception.TopicAlreadyFoundException;
import com.herbalife.exception.TopicNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConferenceService {
    public List<TopicOutputDto> getAllTopics() {
        return Topic
                .streamAll()
                .map(it -> {
                    Topic topic = (Topic) it;
                    return new TopicOutputDto(topic.getId(), topic.getTitle(), topic.getDuration());
                })
                .toList();
    }

    @Transactional
    public void removeTopic(String title) {
        Optional<Topic> optionalTopic = getTopic(title);
        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.delete();
        } else {
            throw new TopicNotFoundException(title);
        }
    }

    @Transactional
    public void addTopic(String title, Integer duration) {
        Optional<Topic> optionalTopic = getTopic(title);
        if (optionalTopic.isEmpty()) {
            Topic topic = new Topic();
            topic.setTitle(title);
            topic.setDuration(duration);
            topic.persist();
        } else {
            throw new TopicAlreadyFoundException(title);
        }

    }

    private Optional<Topic> getTopic(String title) {
        Optional<Topic> optionalTopic = Topic.find("title", title).firstResultOptional();
        return optionalTopic;
    }
}
