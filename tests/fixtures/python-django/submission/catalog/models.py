from django.conf import settings
from django.db import models

class Item(models.Model):
    owner = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    name = models.CharField(max_length=100)
    stock = models.IntegerField(default=0)
