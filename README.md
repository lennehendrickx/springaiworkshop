### Spring AI Workshop - follow along project
https://www.youtube.com/watch?v=FzLABAppJfM

### Ollama setup
1. Install Ollama using Homebrew:
   ```bash
   brew install ollama
   ```
2. Verify the installation:
   ```bash
   ollama version
   ```
3. Start ollama
    ```bash
    ollama serve
    ```
4. Download the desired model (e.g., `gpt-oss:20b, gemma3:12b`):
   ```bash
   ollama pull gpt-oss:20b
   ```
5. Run the model:
   ```bash
   ollama run gpt-oss:20b
   ```
   

### Llama.cpp setup

1. Install Llama.cpp using Homebrew:
   ```bash
   brew install llama.cpp
   ```
2. Verify the installation:
   ```bash
   llama --version
   ```
3. Run the desired model (e.g., `google/gemma-3-12b-it-qat-q4_0-gguf`)
   ```bash
   llama-server -hf google/gemma-3-12b-it-qat-q4_0-gguf --port 1234
   ```