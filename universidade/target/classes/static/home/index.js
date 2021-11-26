(() => {
    const links = document.links;
    const linkAlunos = links.namedItem("linkAlunos");
    const linkFornecedores = links.namedItem("linkFornecedores");
    const linkProfessores = links.namedItem("linkProfessores");

    if ( ! (linkAlunos && linkFornecedores && linkProfessores) )
        return;

    linkAlunos.onclick = async () => await Lista.renderizarLista(Aluno);
    linkFornecedores.onclick = async () => await Lista.renderizarLista(Fornecedor);
    linkProfessores.onclick = async () => await Lista.renderizarLista(Professor);
})();

async function renderizarCorpo(url = "") {
    const corpo = document.getElementById("corpo");
    if (!corpo)
        return;
    corpo.innerHTML = "";
    const html = await Internet.loadHtml(url);
    corpo.append(...html);
}

/** @param {string | Date} data */
function sanitizarData(data) {

    const d = (data instanceof Date) ? data : new Date(data);
    
    return new Date(d.getUTCFullYear(), d.getUTCMonth(), d.getUTCDate());
}