abstract class Document {
    abstract void open();
}

class WordDoc extends Document {
    void open() {
        System.out.println("Opening Word document...");
    }
}

class PdfDoc extends Document {
    void open() {
        System.out.println("Opening PDF document...");
    }
}

abstract class DocFactory {
    abstract Document createDoc();
}

class WordDocFactory extends DocFactory {
    Document createDoc() {
        return new WordDoc();
    }
}

class PdfDocFactory extends DocFactory {
    Document createDoc() {
        return new PdfDoc();
    }
}

public class Factorymethod {
    public static void main(String[] args) {
        DocFactory wordFactory = new WordDocFactory();
        DocFactory pdfFactory = new PdfDocFactory();
        
        Document word = wordFactory.createDoc();
        Document pdf = pdfFactory.createDoc();
        
        word.open();
        pdf.open();
    }
}
