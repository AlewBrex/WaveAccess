package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.model.User;
import java.util.Set;

@Data
@AllArgsConstructor
public class PresentationResponse
{
    private String theme;
    private String content;
    private Set<User> users;
}
