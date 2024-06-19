package com.withmere.withmere.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1346377649L;

    public static final QUser user = new QUser("user");

    public final com.withmere.withmere.global.common.QBaseEntity _super = new com.withmere.withmere.global.common.QBaseEntity(this);

    public final EnumPath<Category> category = createEnum("category", Category.class);

    public final ListPath<com.withmere.withmere.domain.comment.Comment, com.withmere.withmere.domain.comment.QComment> commentList = this.<com.withmere.withmere.domain.comment.Comment, com.withmere.withmere.domain.comment.QComment>createList("commentList", com.withmere.withmere.domain.comment.Comment.class, com.withmere.withmere.domain.comment.QComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final ListPath<com.withmere.withmere.domain.post.Post, com.withmere.withmere.domain.post.QPost> postList = this.<com.withmere.withmere.domain.post.Post, com.withmere.withmere.domain.post.QPost>createList("postList", com.withmere.withmere.domain.post.Post.class, com.withmere.withmere.domain.post.QPost.class, PathInits.DIRECT2);

    public final StringPath pw = createString("pw");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

