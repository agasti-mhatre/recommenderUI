package recommender.recommenderui.Filter;

import android.util.Log;

import org.chromium.net.CronetException;

import java.nio.ByteBuffer;

public class FilterRequestCallback extends org.chromium.net.UrlRequest.Callback {

    @Override
    public void onRedirectReceived(org.chromium.net.UrlRequest request, org.chromium.net.UrlResponseInfo info, String newLocationUrl) throws Exception {
        Log.d("Method called: ", "onRedirectReceived");
    }

    @Override
    public void onResponseStarted(org.chromium.net.UrlRequest request, org.chromium.net.UrlResponseInfo info) throws Exception {
        Log.d("Method called: ", "onResponseStarted");
    }

    @Override
    public void onReadCompleted(org.chromium.net.UrlRequest request, org.chromium.net.UrlResponseInfo info, ByteBuffer byteBuffer) throws Exception {
        Log.d("Method called: ", "onReadCompleted");
    }

    @Override
    public void onSucceeded(org.chromium.net.UrlRequest request, org.chromium.net.UrlResponseInfo info) {
        Log.d("Method called: ", "onSucceeded");
    }

    @Override
    public void onFailed(org.chromium.net.UrlRequest request, org.chromium.net.UrlResponseInfo info, CronetException error) {
        Log.d("Method called: ", "onFailed");
    }
}
