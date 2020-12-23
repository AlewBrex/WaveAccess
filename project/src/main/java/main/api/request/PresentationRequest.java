package main.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.model.User;
import java.util.Set;

@Data
@AllArgsConstructor
public class PresentationRequest
{
    private int id;
    private String theme;
    private String content;
    private Set<User> users;
}
