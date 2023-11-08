<h1 align="center">CryptoApp</h1>

<p align="center">  
฿ Crypto apps utilize real-time data to draw a blueprint for how to envision a real-time data architecture.
</p>
</br>

## Tech stack & Open-source libraries
- Minimum SDK level 24 and Target SDK level 33
- 100% [Kotlin](https://kotlinlang.org/)
- 100% [Compose](https://developer.android.com/jetpack/compose)
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)(StateFlow, SharedFlow) + Coroutine for async programming.
- MVVM + Clean Architecture (Multi Module)
  - Based on the Core, Feature folder, I have modularized it by feature.
- **Realtime Architecture** (Cache + Api + Socket)
  - The architecture is optimized to receive, process, and display real-time data.
- [Hilt](https://dagger.dev/hilt/) for Dependency Injection
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) for request and response data from network using REST API.
- [Thunder](https://github.com/jaeyunn15/Thunder) for WebSocket
  - A websocket library that converts to a Flow type.   
- (TBD) Kotest for unit test

