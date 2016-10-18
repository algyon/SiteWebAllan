/**
 *
 * @author David
 */

    package buildatoryPCK;
    
    import java.util.ArrayList ;
    import java.util.List ;
    import javax.annotation.PostConstruct ;
    import javax.faces.bean.ManagedBean ;

    
    @ManagedBean(name="ImageViewer")
    public class ImageViewer {

        private List<String> images;

        @PostConstruct
        public void init() {
            images = new ArrayList <String>();
                for(int i=1;i<=4;i++) {  
                images.add("Manga"+i+".jpg");
            }
        }

            //images.add("108142.jpg");
            //images.add("144565.jpg");
            //images.add("57497.jpg");
            //images.add("5cl3l0W.jpg");
        
        public List<String> getImages() {
            return images;
        }
    }

