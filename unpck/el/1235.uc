class 1235 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect21
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.700000)
		EffectClass=Class'LineageEffect.el_hydro_blast_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect24
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_hydro_blast_ta'
		bOnMultiTarget=True
	End Object
	Desc="하이드로 블래스트" //Hydro Blast
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect21',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect24',SpecificStage=0)
}