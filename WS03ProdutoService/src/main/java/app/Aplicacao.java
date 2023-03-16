package app;

import static spark.Spark.*;
import service.ProdutoService;


public class Aplicacao {
	
	private static ProdutoService produtoService = new ProdutoService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        post("/slav/insert", (request, response) -> produtoService.insert(request, response));

        get("/slav/:id", (request, response) -> produtoService.get(request, response));
        
        get("/slav/list/:orderby", (request, response) -> produtoService.getAll(request, response));

        get("/slav/update/:id", (request, response) -> produtoService.getToUpdate(request, response));
        
        post("/slav/update/:id", (request, response) -> produtoService.update(request, response));
           
        get("/slav/delete/:id", (request, response) -> produtoService.delete(request, response));

             
    }
}