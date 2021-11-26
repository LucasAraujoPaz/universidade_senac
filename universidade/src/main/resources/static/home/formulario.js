/**
 * @template T
 * @typedef {{
 * readonly nomeDoLink: string,
 * readonly nomeDoFormulario: string,
 * preencher: (objeto: T?) => Promise<void>,
 * obter: () => T
 * }} IFormulario<T>
 */
 
 class Formulario {

    /**
     * @template T
     * @param {IFormularioCRUD<T>} classe
     * @param {T?} objeto
     */
    static preencher(classe, objeto) {
    
        const form = document.forms.namedItem(classe.Formulario.nomeDoFormulario);
        const elements = form?.elements;
        if (!elements)
            return;
                
        for (const element of elements)// @ts-expect-error
            if (objeto?.[element.name] !== undefined)// @ts-expect-error
                element.value = objeto[element.name];

        if (objeto) {
            form.onsubmit = async event => {
                event.preventDefault();
                await classe.CRUD.editar(classe.Formulario.obter());
                await Lista.renderizarLista(classe);
            }
            return;
        }
        
        form.onsubmit = async event => {
            event.preventDefault();
            await classe.CRUD.criar(classe.Formulario.obter());
            await Lista.renderizarLista(classe);
        }
    }
}