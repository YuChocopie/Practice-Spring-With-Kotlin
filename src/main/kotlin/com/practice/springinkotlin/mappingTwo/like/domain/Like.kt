package com.practice.springinkotlin.mappingTwo.like.domain

import javax.persistence.*

@Entity
@Table(name="likes_jy")
class Like(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            var id: Long? = null,
           var likeType: String,
           var postId: Long,
           var userId: Long) {

    constructor(likeType: String, postId: Long, userId: Long):this(null, likeType, userId, postId)

}