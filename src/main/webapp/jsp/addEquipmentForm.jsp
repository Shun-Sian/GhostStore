<form class="form" id="addEquipmentForm" method="post">
    <div class="form-control">
        <label for="EquipmentName">Please, enter your Equipment Name</label>
        <input type="text" id="EquipmentName" name="equipmentName" placeholder="Enter equipment name" />
    </div>
    <div class="form-control">
        <label for="description">Add product description</label>
        <textarea
                id="description"
                name="description"
                placeholder="Enter equipment description"
        >
            </textarea>
    </div>
    <div class="form-control">
        <label for="price">Please, enter your Equipment price</label>
        <input type="text" id="price" name="price" placeholder="Enter equipment price" />
    </div>
    <div class="form-control">
        <label for="addPicture">Add product picture</label>
        <input type="file" id="addPicture" name="picture" placeholder="Add picture" />
    </div>
    <div>
      <input name="username"  hidden="true" value=${username}/>
    </div>
    <button class="btn" id="submitEquipment">Submit</button>
</form>