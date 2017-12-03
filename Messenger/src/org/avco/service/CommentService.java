package org.avco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.avco.dao.DatabaseClass;
import org.avco.datamodel.Comment;
import org.avco.datamodel.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public CommentService() {
		messages.put(1L, new Message(1, "Hello World", "John"));
		messages.put(2L, new Message(2, "Hello Jersey", "Tom"));
	}
	public List<Comment> getAllComments(long messageId) {
		Comment comment = new Comment();
		comment.setAuthor("Tom");
		comment.setMessage("Messege commented");
		comment.setId(1l);
		messages.get(messageId).getComments().put(1L, comment);
		comment = new Comment();
		comment.setAuthor("John");
		comment.setMessage("new comment");
		comment.setId(2l);
		messages.get(messageId).getComments().put(2L, comment);
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
