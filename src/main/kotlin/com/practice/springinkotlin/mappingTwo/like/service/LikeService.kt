package com.practice.springinkotlin.mappingTwo.like.service

import com.practice.springinkotlin.mappingTwo.like.domain.Like
import com.practice.springinkotlin.mappingTwo.like.domain.LikeRepository
import com.practice.springinkotlin.mappingTwo.like.dto.ReqCreateLikeDto
import org.springframework.stereotype.Service

@Service
class LikeService(val likesRepository: LikeRepository) {
    fun create(postId: Long, requestCreateLikeDto: ReqCreateLikeDto): Like {
        val like = Like(requestCreateLikeDto.likeType, requestCreateLikeDto.userId, postId)
        return likesRepository.save(like)
    }

    fun delete(postId: Long, userId: Long): Unit? {
        val like = likesRepository.findByPostIdAndUserId(postId, userId)
        return like.id?.let { likesRepository.deleteById(it) }!!
    }
}