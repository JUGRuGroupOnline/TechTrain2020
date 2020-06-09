package main

import (
	"fmt"
	"log"
	"net/http"
	"os"
	"strings"
)

func main() {
	var envUrl string = os.Getenv("PREV_SERVICE")

	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		resp, err := http.Get(envUrl)
		if err != nil {
			fmt.Println(err)
			return
		}

		bs := make([]byte, 1014)
		n, err := resp.Body.Read(bs)
		var prevResp string = string(bs[:n])
		if strings.EqualFold(prevResp, "МЫ сломали твой") {
			fmt.Fprintf(w, prevResp+" код,")
		} else {
			fmt.Fprintf(w, "task4 error: got \""+prevResp+"\" from "+envUrl)
		}
	})

	log.Fatal(http.ListenAndServe(":8080", nil))

}
