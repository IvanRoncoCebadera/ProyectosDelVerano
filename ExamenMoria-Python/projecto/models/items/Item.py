class Item:
    def __init__(self, id: int):
        self.id = id

    def __str__(self) -> str:
        return f"Item({self.id})"