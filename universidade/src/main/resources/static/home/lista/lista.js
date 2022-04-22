class Lista {

    /**
     * @template T
     * @param {IFormularioCRUD<T & IEntidadeComId>} classe
     */
    static async renderizarLista(classe) {
        await renderizarCorpo("lista/lista.html");

        const lista = await classe.CRUD.listar();
        this.#listar(lista);

        
        const criar = /** @type {HTMLButtonElement} */
            (document.querySelector("#lista [name='criar']"));
        
        const editar = /** @type {HTMLButtonElement} */
            (document.querySelector("#lista [name='editar']"));
        
        const deletar = /** @type {HTMLButtonElement} */
            (document.querySelector("#lista [name='deletar']"));

        criar.onclick = async () => await classe.Formulario.preencher(null);
        editar.onclick = async () => {
            const id = this.#obterIdSelecionado();
            if (id === -1) 
                return;

            const objeto = await classe.CRUD.obter(id);
            await classe.Formulario.preencher(objeto);
        };
        deletar.onclick = () => {
            const id = this.#obterIdSelecionado();
            if (id === -1) 
                return;

            classe.CRUD.deletar(id);
            document.links.namedItem(classe.Formulario.nomeDoLink)?.click()
        };
    }

    /** @param {(implements & IEntidadeComId)[]} lista */
    static #listar(lista) {

        if (isNaN(Number(lista?.[0]?.id)))
            return;

        const options = lista.map(elemento => {
            const option = document.createElement("option");
            option.value = elemento.id.toString();
            option.textContent = JSON.stringify(elemento);
            return option;
        });

        document.querySelector("#lista [name='seletor']")?.append(...options);
    }
    
    static #obterIdSelecionado() {

        const select = /** @type {HTMLSelectElement} */
            (document.querySelector("#lista [name='seletor']"));
        const id = select.selectedOptions[0]?.value;
        return sanitizarId(id);
    }
}