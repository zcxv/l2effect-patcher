class 1231 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect18
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.el_aura_burn_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect25
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_aura_flare_ta'
	End Object
	Desc="오라 플래어" //Aura Flare
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect18',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect25',SpecificStage=0)
}