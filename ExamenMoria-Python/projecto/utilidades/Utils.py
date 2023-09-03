def quedanPersonajesVivos(personajes: list) -> bool:
    for pj in personajes:
        if pj.estado == False:
            return False
    return True