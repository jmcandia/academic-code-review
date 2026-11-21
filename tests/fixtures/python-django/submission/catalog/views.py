import json
from django.http import JsonResponse
from django.shortcuts import get_object_or_404
from django.views.decorators.http import require_http_methods
from .models import Item

@require_http_methods(["GET", "POST"])
def item_list_create(request):
    if not request.user.is_authenticated:
        return JsonResponse({"error": "authentication required"}, status=401)
    if request.method == "GET":
        return JsonResponse({"items": list(Item.objects.filter(owner=request.user).values("id", "name", "stock"))})
    data = json.loads(request.body or b"{}")
    name = str(data.get("name", "")).strip()
    if not name:
        return JsonResponse({"error": "name is required"}, status=400)
    stock = int(data.get("stock", 0))
    if stock < 0:
        return JsonResponse({"error": "stock must be nonnegative"}, status=400)
    item = Item.objects.create(owner=request.user, name=name, stock=stock)
    return JsonResponse({"id": item.id, "name": item.name, "stock": item.stock}, status=201)

@require_http_methods(["PATCH"])
def item_detail(request, item_id):
    if not request.user.is_authenticated:
        return JsonResponse({"error": "authentication required"}, status=401)
    item = get_object_or_404(Item, id=item_id)
    data = json.loads(request.body or b"{}")
    if "name" in data:
        item.name = str(data["name"]).strip()
        if not item.name:
            return JsonResponse({"error": "name is required"}, status=400)
    if "stock" in data:
        item.stock = int(data["stock"])
    item.save()
    return JsonResponse({"id": item.id, "name": item.name, "stock": item.stock})
