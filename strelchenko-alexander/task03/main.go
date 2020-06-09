package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
)

func getEnvOrDefault(key, defaultValue string) string {
	value := os.Getenv(key)
	if len(value) == 0 {
		return defaultValue
	}
	return value
}

func handleHomeLink(w http.ResponseWriter, r *http.Request) {
	var task02host string = getEnvOrDefault("TASK02_HOST", "localhost")
	var task02port string = getEnvOrDefault("TASK02_PORT", "8081")
	resp, _ := http.Get("http://" + task02host + ":" + task02port)
	defer resp.Body.Close()
	buf, _ := ioutil.ReadAll(resp.Body)
	fmt.Fprintf(w, string(buf) + " твой")
}

func main() {
	http.HandleFunc("/", handleHomeLink)
	http.ListenAndServe(":8082", nil)
}
