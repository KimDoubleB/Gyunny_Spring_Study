package com.example.demo.mapper;

import com.example.demo.dto.Post;
import com.example.demo.model.PostModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    // 게시글 전체조회
    @Select("SELECT * FROM posts")
    List<Post> findAll();

    // 게시글 하나조회
    @Select("SELECT * FROM posts WHERE postIdx = #{postIdx}")
    Post findByPostIdx(@Param("postIdx") int postIdx);

    // 게시글 등록
    @Insert("INSERT INTO posts (authors, title, createdAt, memberIdx) VALUES (#{postModel.authors}, #{postModel.title}, #{postModel.createdAt}, #{memberIdx})")
    @Options(useGeneratedKeys = true, keyColumn = "postIdx")
    int insertPost(@Param("postModel") PostModel postModel, @Param("memberIdx") int memberIdx);

    // 게시글 수정
    @Update("UPDATE posts SET authors = #{postModel.authors}, title = #{postModel.title}, createdAt = #{postModel.createdAt} WHERE postIdx = #{postIdx}")
    void updatePost(PostModel postModel, @Param("postIdx") int postIdx);

    // 게시글 삭제
    @Delete("DELETE FROM posts WHERE postIdx = #{postIdx}")
    void deletePost(@Param("postIdx") int postIdx);
}
