package co.com.tactusoft.medical.view.backing;

import java.io.InputStream;
import java.math.BigDecimal;

import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("request")
public class PhotoStreamer {

	private static final Logger logger = LoggerFactory
			.getLogger(PhotoStreamer.class);
	private static StreamedContent defaultFileContent;
	private StreamedContent fileContent;

	public StreamedContent getFileContent() {
		String photoId = FacesUtil.getParam("image_id");
		if (photoId == null || photoId.equals("")) {
			fileContent = defaultFileContent;
			logger.info("Id was null or empty. Retrieved default file content.");
		} else {
			BigDecimal parsedId = new BigDecimal(photoId);
			if (parsedId.intValue() < 0) {
				fileContent = defaultFileContent;
				logger.info("Invalid Id. Retrieved default file content.");
			}
			
			CarouselBacking carouselBacking = FacesUtil.findBean("carouselBacking");
			InputStream inputStream = carouselBacking.getImages().get(parsedId).getStream();
			fileContent = new DefaultStreamedContent(inputStream, "image/jpg");
			
			/*ClassLoader contextClassLoader = Thread.currentThread()
					.getContextClassLoader();
			InputStream inputStream = contextClassLoader
					.getResourceAsStream("resources/images/Photo - " + parsedId
							+ ".png");
			fileContent = new DefaultStreamedContent(inputStream, "image/png");*/
			logger.info("Retrieved file content for image {}.", parsedId);
		}
		logger.trace("Exited method getFileContent.");
		return fileContent;
	}

	public void setFileContent(StreamedContent fileContent) {
		this.fileContent = fileContent;
	}

	static {
		ClassLoader contextClassLoader = Thread.currentThread()
				.getContextClassLoader();
		InputStream inputStream = contextClassLoader
				.getResourceAsStream("resources/images/Photo - 0.png");
		defaultFileContent = new DefaultStreamedContent(inputStream,
				"image/png");
	}

}
