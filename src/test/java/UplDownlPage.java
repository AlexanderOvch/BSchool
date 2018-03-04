import org.openqa.selenium.By;

public class UplDownlPage {

    static String LinkUploadPage = "https://app.box.com/folder/0";
    static By UploadLink = By.cssSelector("input[class=upload-handler-picker]");
    static String FileLink = "E:/game.txt";

    static String LinkDownloadPage = "https://app.box.com/file/";
    static By DownloadFileLink = By.xpath("//*[@id=\"mod-file-list-minimal-1\"]/div[1]/ol/li[1]");
    static String DownloadFileID = "data-resin-file_id";

    static By ButtonLink = By.xpath("//*[@id=\"mod-preview-adv-header-1\"]/div[2]/button[3]");
}
