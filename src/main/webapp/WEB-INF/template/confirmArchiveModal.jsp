<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="confirmArchiveModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-warning text-dark">
                <h5 class="modal-title">Potvrda arhiviranja</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Zatvori"></button>
            </div>
            <div class="modal-body">
                <p>Da li ste sigurni da želite da arhivirate ovu Gembu? Posle toga više neće biti moguće vršiti izmene.</p>
            </div>
            <div class="modal-footer">
                <form id="confirmArchiveForm" method="post">
                    <input type="hidden" name="gembaId" id="archiveId">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Odustani</button>
                    <button type="submit" class="btn btn-warning">Arhiviraj</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
var confirmArchiveModal = document.getElementById('confirmArchiveModal');
confirmArchiveModal.addEventListener('show.bs.modal', function (event) {
    var button = event.relatedTarget; // dugme koje je kliknuto
    var id = button.getAttribute('data-id');
    var action = button.getAttribute('data-action');

    // popuni formu modala
    document.getElementById('archiveId').value = id;
    document.getElementById('confirmArchiveForm').action = action;
});
</script>
