<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Potvrda brisanja</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="confirmDeleteText">Da li ste sigurni da želite da obrišete ovaj zapis?</div>
                <div id="deleteName" class="fw-bold mt-2 text-break"></div>
            </div>
            <div class="modal-footer">
                <form id="confirmDeleteForm" method="post">
                    <input type="hidden" name="id" id="deleteId">
                    <input type="hidden" name="headerAktivnost" id="deleteHeaderAktivnost">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Odustani</button>
                    <button type="submit" class="btn btn-danger">Obriši</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
var confirmDeleteModal = document.getElementById('confirmDeleteModal');

confirmDeleteModal.addEventListener('show.bs.modal', function (event) {
    var button = event.relatedTarget;

    var id = button.getAttribute('data-id');
    var action = button.getAttribute('data-action');
    var title = button.getAttribute('data-title');
    var name = button.getAttribute('data-name');
    var headerAktivnost = button.getAttribute('data-header-aktivnost');

    document.getElementById('deleteId').value = id;
    document.getElementById('confirmDeleteForm').action = action;

    var headerInput = document.getElementById('deleteHeaderAktivnost');
    if (headerInput) {
        headerInput.value = headerAktivnost ? headerAktivnost : "";
    }

    document.getElementById('confirmDeleteText').textContent =
        "Da li ste sigurni da želite da obrišete " + title;

    document.getElementById('deleteName').textContent = name || "";
});
</script>

