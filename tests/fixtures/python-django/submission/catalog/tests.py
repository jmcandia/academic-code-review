import json
from django.contrib.auth import get_user_model
from django.test import TestCase
from .models import Item

class ItemApiTests(TestCase):
    def setUp(self):
        User = get_user_model()
        self.owner = User.objects.create_user(username="owner", password="x")
        self.other = User.objects.create_user(username="other", password="x")
        self.item = Item.objects.create(owner=self.owner, name="Food", stock=4)

    def test_owner_can_update_item(self):
        self.client.force_login(self.owner)
        response = self.client.patch(f"/items/{self.item.id}/", data=json.dumps({"stock": 5}), content_type="application/json")
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json()["stock"], 5)

    def test_other_user_cannot_update_item(self):
        self.client.force_login(self.other)
        response = self.client.patch(f"/items/{self.item.id}/", data=json.dumps({"stock": 9}), content_type="application/json")
        self.assertIn(response.status_code, (403, 404))

    def test_negative_stock_update_is_rejected(self):
        self.client.force_login(self.owner)
        response = self.client.patch(f"/items/{self.item.id}/", data=json.dumps({"stock": -3}), content_type="application/json")
        self.assertEqual(response.status_code, 400)
