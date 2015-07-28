class 5117 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect52
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_new_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect53
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.e_u832'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect74
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_ca'
	End Object
	Desc="사이렌전용마이트" //Siren -only Dynamite
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect52',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect53',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect74',SpecificStage=0)
}