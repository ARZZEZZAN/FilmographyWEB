package filmography.ARZ.repos.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Film {
    private Long id;
    private String title;
    private String url;
    private boolean watched;
}
