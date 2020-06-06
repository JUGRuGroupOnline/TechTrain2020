package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
)

func handler(w http.ResponseWriter, r *http.Request) {
	response, _ := http.Get("http://localhost:8484/forth")
	defer response.Body.Close()
	// reads html as a slice of bytes
	resApi, _ := ioutil.ReadAll(response.Body)
	if string(resApi) == "Мы сломали твой код," {
		fmt.Fprintf(w, "%s уронили", string(resApi))
	} else {
		fmt.Fprintf(w, "Response is %s!", resApi)
	}
}
func main() {
	http.HandleFunc("/fifth", handler)

	fmt.Println("Starting Restful services...")
	fmt.Println("Using port:8585")
	err := http.ListenAndServe(":8585", nil)
	log.Print(err)
	errorHandler(err)

}
func errorHandler(err error) {
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
}
