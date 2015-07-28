class 271 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect24
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_dance_of_warrior_ta'
	End Object
	Desc="댄스 오브 워리어" //Dance of Warrior
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect24',SpecificStage=0)
}