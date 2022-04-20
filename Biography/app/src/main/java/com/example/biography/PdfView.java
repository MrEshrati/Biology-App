package com.example.biography;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.util.ArrayList;
import java.util.List;

public class PdfView extends AppCompatActivity implements OnLoadCompleteListener, OnPageChangeListener, OnPageErrorListener {

    PDFView pdfView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pdf_view);

        pdfView = findViewById(R.id.pdfView);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("\tLoading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        pdfView.fromAsset("gahname.pdf")
                .pages(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55)
                .defaultPage(0)
                .enableSwipe(true)
                .enableAnnotationRendering(true)
                .onLoad(PdfView.this)
                .onPageChange(PdfView.this)
                .scrollHandle(new DefaultScrollHandle(PdfView.this))
                .enableDoubletap(true)
                .onPageError(PdfView.this)
                .swipeHorizontal(true)
                .spacing(0)
                .nightMode(false)
                .pageFitPolicy(FitPolicy.WIDTH)
                .autoSpacing(false)
                .load();

    }

    @Override
    public void loadComplete(int nbPages) { progressDialog.dismiss(); }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}