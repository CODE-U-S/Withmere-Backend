package com.withmere.withmere.domain.post.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withmere.withmere.domain.post.Category;
import com.withmere.withmere.domain.post.Field;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.post.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.withmere.withmere.domain.post.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<Post> findAllByCategory(Category category) {
        return queryFactory
                .selectFrom(post)
                .where(post.category.eq(category))
                .fetch();
    }

    @Override
    public List<Post> findAllByCategoryAndTitleContainingOrContentContaining(Category category, String title, String content) {
        return queryFactory
                .selectFrom(post)
                .where(post.category.eq(category).or(post.title.contains(title).or(post.content.contains(content))))
                .fetch();
    }

    @Override
    public List<Post> findAllByStatus(Status status) {
        return queryFactory
                .selectFrom(post)
                .where(post.status.eq(status))
                .fetch();
    }

    @Override
    public List<Post> findAllByCategoryAndStatus(Category category, Status status) {
        return queryFactory
                .selectFrom(post)
                .where(post.category.eq(category).and(post.status.eq(status)))
                .fetch();
    }

    @Override
    public List<Post> findAllByTitleContainingOrContentContaining(String title, String content) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(title).or(post.content.contains(content)))
                .fetch();
    }

    @Override
    public List<Post> findAllByCategoryAndFieldAndStatusOrderByLikeCountDesc(Category category, Field field, Status status) {
        return queryFactory
                .selectFrom(post)
                .where(
                        post.field.eq(field)
                                .and(post.status.eq(status))
                                .and(post.category.eq(category))
                )
                .orderBy(post.likeCount.desc())
                .fetch();
    }

    @Override
    public List<Post> findAllByCategoryAndFieldAndStatusOrderByCommentCountDesc(Category category, Field field, Status status) {
        return queryFactory
                .selectFrom(post)
                .where(
                        post.field.eq(field)
                                .and(post.status.eq(status))
                                .and(post.category.eq(category))
                )
                .orderBy(post.commentCount.desc())
                .fetch();
    }

    @Override
    public List<Post> findAllByCategoryAndFieldAndStatusOrderByCreatedDateDesc(Category category, Field field, Status status) {
        return queryFactory
                .selectFrom(post)
                .where(
                        post.field.eq(field)
                                .and(post.status.eq(status))
                                .and(post.category.eq(category))
                )
                .orderBy(post.createdDate.desc())
                .fetch();
    }
}
