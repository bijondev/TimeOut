# TimeOut
Retrofit TimeOut using okHttp Client


Retrofit is a library that makes it easy to perform network requests in Android. It can be used with the OkHttp library to set timeouts for the requests.

Here is an example of how to set timeouts using OkHttp with Retrofit:

    Add the OkHttp library as a dependency in your app's build.gradle file:

implementation 'com.squareup.okhttp3:okhttp:4.9.0'

    Create an OkHttpClient instance with the desired timeout values and pass it to the Retrofit builder when creating the Retrofit instance:

OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build();

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

This will set the read timeout and connect timeout values to 30 seconds for all requests made with this Retrofit instance.

I hope this helps give you an idea of how to set timeouts using OkHttp with Retrofit in an Android app. Let me know if you have any questions.
