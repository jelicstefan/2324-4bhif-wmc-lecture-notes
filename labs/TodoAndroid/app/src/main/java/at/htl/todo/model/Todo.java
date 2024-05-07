package at.htl.todo.model;

public record Todo(
        Long userId,
        Long id,
        String title,
        boolean completed
) { }

/**
 * userId	1
 * id	1
 * title	"delectus aut autem"
 * completed	false
 */