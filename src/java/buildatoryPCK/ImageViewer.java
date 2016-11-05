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
                for(int i=1;i<=3;i++) {  
                images.add("Config"+i+".jpg");
            }
        }
     
        public List<String> getImages() {
            return images;
        }
    }

