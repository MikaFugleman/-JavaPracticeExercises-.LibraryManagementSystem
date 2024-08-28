public class eBook extends Book {

    private final String format;
    private final double fileSize;
    private final String downloadLink;
    private final boolean drmProtected;


    public eBook(String title, String author, String ISBN, String format, double fileSize, String downloadLink, boolean drmProtected) {
        super(title, author, ISBN);
        this.format = format;
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
        this.drmProtected = drmProtected;
    }


    // All getters:

    public String getFormat() {
        return format;
    }

    public double getFileSize() {
        return fileSize;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public boolean isDrmProtected() {
        return drmProtected;
    }




    // eBook-specific methods:




    // eBook-specific overridden methods:


    @Override
    public String displayBookDetails() {

        return String.format("Title: %s, Author: %s, ISBN: %s, Format: %s, File size: %f," +
                        "Download link: %s, drmProtected: %b" , super.getTitle(), super.getAuthor(),
                super.getISBN(), format, fileSize, downloadLink, drmProtected);
    }

    @Override
    public boolean isBorrowed() {
        System.out.println("An eBook can not be borrowed/returned. You may download an eBook instead.");
        return false;
    }

    @Override
    public void borrowBook() {
        System.out.println("An eBook can not be borrowed/returned.");
    }

    @Override
    public void returnBook() {
        System.out.println("An eBook can not be borrowed/returned.");
    }


}
