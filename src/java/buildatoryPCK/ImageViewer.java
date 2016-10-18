/**
 *
 * @author David
 */

    package buildatoryPCK;
    
    import java.util.ArrayList ;
    import java.util.List ;
    import javax.annotation.PostConstruct ;
    import javax.faces.bean.ManagedBean ;

    @ManagedBean
    public class ImageViewer {

        private List<String> images;

        @PostConstruct
        public void init() {
            images = new ArrayList <String>();
            images.add("108142.jpg");
            images.add("144565.jpg");
            images.add("57497.jpg");
            images.add("5cl3l0W.jpg");
        }

        public List<String> getImages() {
            return images;
        }
    }

