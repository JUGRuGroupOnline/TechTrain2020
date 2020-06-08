package main

import (
	"fmt"
	"os"
    "log"
	"net/http"
	"io/ioutil"
)

func main() {
    handleRequests()
}

func index(w http.ResponseWriter, r *http.Request){
	standard_asnwer := "Мы сломали твой код, уронили"
	url := os.Getenv("SERVICE_ENTRYPOINT")
	if url == "" {
		fmt.Fprintf(w, "Переменная среды не задана: SERVICE_ENTRYPOINT")
		return;
	}
	result := getStringFromUrl(url)
	if result != standard_asnwer {
		fmt.Fprintf(w, "Ответ не соответствует ожидаемому значению: " + standard_asnwer)
	} else {
		answer := result + " сервак."
		fmt.Fprintf(w, answer)	
	}	
}

func handleRequests() {
    http.HandleFunc("/", index)
    log.Fatal(http.ListenAndServe(":80", nil))
}

func getStringFromUrl(url string) string {
	resp, _ := http.Get(url)
	defer resp.Body.Close()
	bodyBytes, _ := ioutil.ReadAll(resp.Body)
	return string(bodyBytes)
}